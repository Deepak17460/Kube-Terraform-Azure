<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.nagarro.UserManagement.model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">User List</h1>
        <div class="text-center mb-3">
            <a href="addUser" class="btn btn-success">Add User</a>
        </div>
        <table class="table table-bordered">
        	<caption>User Information</caption>
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    @SuppressWarnings("unchecked")
                    List<User> users = (List<User>) request.getAttribute("users");
                    if (users != null) {
                        for (User user : users) {
                %>
                <tr>
                    <td><%= user.getId() %></td>
                    <td><%= user.getName() %></td>
                    <td><%= user.getEmail() %></td>
                    <td>
                        <a href="user?id=<%= user.getId() %>" class="btn btn-info btn-sm">View</a>
                        <a href="updateUser?id=<%= user.getId() %>" class="btn btn-warning btn-sm">Update</a>
                        <a href="deleteUser?id=<%= user.getId() %>" class="btn btn-danger btn-sm">Delete</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-xSMMctUcm29duzRl1b/tBfGDDUiRhR0ODK8JqB3D4QsnqkI+7+nwvcL9oRV2TNU3" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-KyZXEAg3QhqLMpG8r+Knujsl5+gbg4tqtcRxpXSc6l3ia4abt0G4JXf+nWtq8qKg" crossorigin="anonymous"></script>
</body>
</body>
</html>
