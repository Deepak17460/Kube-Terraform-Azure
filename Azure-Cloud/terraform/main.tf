data "azurerm_resource_group" "rg" {
  name     = var.resource_group_name
  # location = var.location
}

data "azurerm_container_registry" "existing_acr" {
  name                = var.acr_name
  resource_group_name = data.azurerm_resource_group.rg.name
}

resource "azurerm_role_assignment" "role_acrpull" {
  scope                            = data.azurerm_container_registry.existing_acr.id
  role_definition_name             = "AcrPull"
  principal_id                     = azurerm_kubernetes_cluster.aks.kubelet_identity.0.object_id
  skip_service_principal_aad_check = true
}

resource "azurerm_virtual_network" "vnet" {
  name                = "aks-vnet"
  address_space       = ["10.0.0.0/16"]
  location            = data.azurerm_resource_group.rg.location
  resource_group_name = data.azurerm_resource_group.rg.name
}
 
resource "azurerm_subnet" "subnet" {
  name                 = "aks-subnet"
  resource_group_name  = data.azurerm_resource_group.rg.name
  virtual_network_name = azurerm_virtual_network.vnet.name
  address_prefixes     = ["10.0.0.0/24"]
}
 
resource "azurerm_network_security_group" "nsg" {
  name                = "aks-nsg"
  location            = data.azurerm_resource_group.rg.location
  resource_group_name = data.azurerm_resource_group.rg.name
 
  security_rule {
    name                       = "Allow-NodePort"
    priority                   = 1000
    direction                  = "Inbound"
    access                     = "Allow"
    protocol                   = "Tcp"
    source_port_range          = "*"
    destination_port_ranges    = ["30000-32767"]
    source_address_prefix      = "*"
    destination_address_prefix = "*"
  }
}
 
resource "azurerm_subnet_network_security_group_association" "nsg_association" {
  subnet_id                 = azurerm_subnet.subnet.id
  network_security_group_id = azurerm_network_security_group.nsg.id
}

resource "azurerm_kubernetes_cluster" "aks" {
  name                = var.kubernetes_cluster_name
  kubernetes_version  = var.kubernetes_version
  location            = var.location
  resource_group_name = data.azurerm_resource_group.rg.name
  dns_prefix          = var.dns_prefix

  default_node_pool {
    name                = "additional"
    node_count          = var.node_count
    vm_size             = "Standard_DS2_v2"
    type                = "VirtualMachineScaleSets"
    zones               = [1, 2, 3]
    enable_auto_scaling = false
    enable_node_public_ip = true
    temporary_name_for_rotation = "akstemp"
  }

  identity {
    type = "SystemAssigned"
  }

  network_profile {
    load_balancer_sku = "standard"
    network_plugin    = "azure"
    load_balancer_profile {
      managed_outbound_ip_count = 2
    }
  }
}

