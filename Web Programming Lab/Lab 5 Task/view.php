<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Data</title>
    <link rel="stylesheet" href="table.css">
</head>

<body>

    <?php

    $connection = mysqli_connect('localhost', 'root', '', 'reg_db');

    if (!$connection) {
        die("Connection failed: " . mysqli_connect_error());
    }

    $show_query = "SELECT * FROM reg_table";
    $show = mysqli_query($connection, $show_query);
    $count = mysqli_num_rows($show);

    if ($count > 0) {
        ?>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
            </thead>
            <?php

            while ($row = mysqli_fetch_assoc($show)) {

                $id = $row["id"];
                $username = $row["username"];
                $email = $row["email"];
                ?>

                <tbody>
                    <tr>
                        <td>
                            <?php echo $id; ?>
                        </td>
                        <td>
                            <?php echo $username; ?>
                        </td>
                        <td>
                            <?php echo $email; ?>
                        </td>
                        <td><a href="edit.php?id=<?php echo $id ?>">Update</a> || <a
                                href="delete.php?id=<?php echo $id ?>">Delete</a></td>
                    </tr>
                </tbody>

            <?php
            }

            //Task-2: add specific messages whenever a data is updated
            if (isset($_GET['updation']) && $_GET['updation'] == 'success') {
                echo "<p>Data updated successfully.</p>";
            }

            //Task-2: add specific messages whenever a data is deleted
            if (isset($_GET['deletion']) && $_GET['deletion'] == 'success') {
                echo "<p>Data deleted successfully.</p>";
            }
            ?>
        </table>
        <?php
    } else {
        echo "No data in database.";
    }
    mysqli_close($connection);
    ?>


</body>

</html>