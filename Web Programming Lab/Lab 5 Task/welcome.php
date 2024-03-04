<!-- Task-3: Login -->
<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $username = $_POST['username'];
    $password = $_POST['password'];

    $connection = mysqli_connect('localhost', 'root', '', 'reg_db');

    if (!$connection) {
        die("Connection failed: " . mysqli_connect_error());
    }

    $query = "SELECT * FROM reg_table WHERE username='$username' AND password='$password'";
    $result = mysqli_query($connection, $query);
    $count = mysqli_num_rows($result);

    if ($count == 1) {
        echo "<h2>Welcome, $username!</h2>";
    } else {
        echo "<h2>Invalid username or password.</h2>";
    }

    mysqli_close($connection);
}
?>