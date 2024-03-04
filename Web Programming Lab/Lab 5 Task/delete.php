<?php
$connection = mysqli_connect('localhost', 'root', '', 'reg_db');

if (!$connection) {
    die("Connection failed: " . mysqli_connect_error());
}

$del_id =  $_REQUEST['id'];

$delete_query = "DELETE FROM reg_table where id=$del_id";

$delete =  mysqli_query($connection, $delete_query);
//confirm deletion
if ($delete) {
    header("location: view.php?deletion=success");
} else {
    echo "Error deleting data: " . mysqli_error($connection);
}

mysqli_close($connection);
?>
