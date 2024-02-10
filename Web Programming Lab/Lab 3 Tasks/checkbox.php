<html>
<head><title>Personality</title></head>
<body>

<form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="GET">
Select your personality attributes:<br />
Perky <input type="checkbox" name="attributes[]" value="perky" /><br />
Morose <input type="checkbox" name="attributes[]" value="morose" /><br />
Thinking <input type="checkbox" name="attributes[]" value="thinking" /><br />
Feeling <input type="checkbox" name="attributes[]" value="feeling" /><br />
Spend-thrift <input type="checkbox" name="attributes[]" value="spend-thrift" /><br />
Shopper <input type="checkbox" name="attributes[]" value="shopper" /><br />
<br />
<input type="submit" name="s" value="Record My personality!" />
</form>

<?php
    // Write PHP code here
    if(isset($_GET['attributes'])) {
        $selected_attributes = $_GET['attributes'];
        echo "You selected: <br>";
        foreach($selected_attributes as $attribute) {
            echo $attribute . "<br>";
        }
    }
?>

</body>
</html>
