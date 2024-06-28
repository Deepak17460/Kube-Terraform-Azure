terraform {
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "~> 3.0"
    }
  }
  backend "azurerm" {
    resource_group_name   = "kanikamahajan01"
    storage_account_name  = "kanika"
    container_name        = "terraform"
    key                   = "terraform.tfstate"
  }
}

provider "azurerm" {
  skip_provider_registration = true
  subscription_id            = var.subscription_id
  client_id                  = var.client_id
  client_secret              = var.client_secret
  tenant_id                  = var.tenant_id
  features {}
}