<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration</title>
    <link rel="stylesheet" href="reg.css">
</head>

<body>

    <div class="container">
        <h2>User Registration Form</h2>

        <form action="reg.php" method="POST">
            <input type="text" name="username" placeholder="Username" required>
            <input type="email" name="email" placeholder="Email" required>
            <input type="password" name="password" placeholder="Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                title="Password must contain at least one number, one uppercase and one lowercase letter, and at least 8 or more characters"
                required>
            <input type="submit" name="submit" value="Submit">
        </form>
    </div>

</body>

</html>
<?php

if (isset($_POST['submit'])) {

    $username = trim($_POST['username']);
    $email = trim($_POST['email']);
    $password = $_POST['password'];

    //Task-1: added constraints: restrict empty strings,
    //applied unique username, maintained specific password structure

    if (empty($username) || empty($email) || empty($password)) {
        die("Please fill out all fields.");
    }

    if (!preg_match('/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/', $password)) {
        die("Password must contain at least one number, one uppercase and one lowercase letter, and at least 8 or more characters");
    }

    $connection = mysqli_connect('localhost', 'root', '', 'reg_db');

    if (!$connection) {
        die("Connection failed: " . mysqli_connect_error());
    }
    $check_query = "SELECT * FROM reg_table WHERE username = '$username'";
    $check_result = mysqli_query($connection, $check_query);
    if (mysqli_num_rows($check_result) > 0) {
        die("Username already exists.");
    }

    $insert_query = "INSERT INTO reg_table (username, email, password) ";
    $insert_query .= "VALUES ('$username', '$email', '$password')";

    $insert = mysqli_query($connection, $insert_query);

    if (!$insert) {
        die("Not inserted: " . mysqli_error($connection));
    }



    //Task-2: add specific messages whenever a data is inserted

    if ($insert) {
        echo "Data inserted successfully.";
    } else {
        die("Not inserted: " . mysqli_error($connection));
    }

    mysqli_close($connection);
}
?>