variable "subscription_id" {
  description = "Azure Subscription Id"
  type        = string
}

variable "client_id" {
  description = "Client Id"
  type        = string
}

variable "client_secret" {
  description = "Client secret"
  type        = string
  sensitive   = true
}

variable "tenant_id" {
  description = "Tenant Id "
  type        = string
}

variable "resource_group_name" {
  description = "The name of the resource group"
  type        = string
}

variable "location" {
  description = "The location of the resource group"
  type        = string
}

variable "kubernetes_cluster_name" {
  description = "The name of the AKS cluster"
  type        = string
  default     = "myAKSCluster"
}

variable "kubernetes_version" {
  description = "Kubernetes version"
  type        = string
}

variable "node_count" {
  description = "The number of nodes in the default node pool"
  type        = number
}

variable "vm_size" {
  description = "The size of the VMs in the default node pool"
  type        = string
  default     = "Standard_DS2_v2"
}

variable "dns_prefix" {
  description = "The DNS prefix for the AKS cluster"
  type        = string
  default     = "myaks"
}
variable "acr_name" {
  type        = string
  description = "ACR name"
}
