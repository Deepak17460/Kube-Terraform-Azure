<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update User</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Update User</h1>
        <form action="updateUser" method="post" class="form-horizontal">
            <input type="hidden" name="id" value="${user.id}">
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">Name:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="name" value="${user.name}" required>
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">Email:</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" name="email" value="${user.email}" required>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-warning">Update User</button>
                </div>
            </div>
        </form>
        <div class="text-center">
            <a href="users" class="btn btn-primary">Back to Users</a>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-xSMMctUcm29duzRl1b/tBfGDDUiRhR0ODK8JqB3D4QsnqkI+7+nwvcL9oRV2TNU3" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-KyZXEAg3QhqLMpG8r+Knujsl5+gbg4tqtcRxpXSc6l3ia4abt0G4JXf+nWtq8qKg" crossorigin="anonymous"></script>
</body>
</body>
</html>
