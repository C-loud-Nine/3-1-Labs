<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Data</title>
    <link rel="stylesheet" href="reg.css">
</head>

<body>


    <?php

        $connection = mysqli_connect('localhost', 'root', '', 'reg_db');

        if (!$connection) {
            die("Connection failed: " . mysqli_connect_error());
        }
        if(isset($_REQUEST['id'])) {
            $edit_id = $_REQUEST['id'];
            $edit_query =  "SELECT * FROM reg_table where id = $edit_id";
            $info = mysqli_query($connection, $edit_query);
            while($row = mysqli_fetch_assoc($info)) {
    
    ?>
     <div class="container">
        <h2>Update Data</h2>
        <form action="update.php" method="POST">
            <label for="username">Username</label>
            <input type="text" name="username" value="<?php echo $row['username'] ?>">
            <label for="email">Email</label>
            <input type="email" name="email" value="<?php echo $row['email'] ?>">
            <label for="password">Password</label>
            <input type="password" name="password" value="<?php echo $row['username'] ?>">
            <input type="submit" name="submit" value="Update">
            <input type="hidden" name="hidden_id" value="<?php echo $edit_id?>">
        </form>
    </div>

    <?php
        }
    }
    mysqli_close($connection);
    ?>

</body>

</html>