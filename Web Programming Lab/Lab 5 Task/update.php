<?php
$connection = mysqli_connect('localhost', 'root', '', 'reg_db');

if (!$connection) {
    die("Connection failed: " . mysqli_connect_error());
}

if (isset($_POST["submit"])) {
    $u_username = $_POST['username'];
    $u_email = $_POST['email'];
    $u_password = $_POST['password'];
    $u_id = $_POST['hidden_id'];

    $update_query = "UPDATE reg_table SET username='$u_username', email='$u_email', password='$u_password' WHERE id='$u_id'";
    $update = mysqli_query($connection, $update_query);
    //confirm updation
    if ($update) {
        header("location: view.php?updation=success"); 
    } else {
        echo "Update failed: " . mysqli_error($connection);
    }
}

mysqli_close($connection);
?>
