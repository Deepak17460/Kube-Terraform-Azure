<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.nagarro.UserManagement.model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">User Details</h1>
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">ID: ${user.id}</h5>
                <p class="card-text">Name: ${user.name}</p>
                <p class="card-text">Email: ${user.email}</p>
                <a href="users" class="btn btn-primary">Back to Users</a>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-xSMMctUcm29duzRl1b/tBfGDDUiRhR0ODK8JqB3D4QsnqkI+7+nwvcL9oRV2TNU3" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-KyZXEAg3QhqLMpG8r+Knujsl5+gbg4tqtcRxpXSc6l3ia4abt0G4JXf+nWtq8qKg" crossorigin="anonymous"></script>
</body>
</body>
</html>
