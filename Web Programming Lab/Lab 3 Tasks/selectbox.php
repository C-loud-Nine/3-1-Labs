<html>
<head><title>Personality</title></head>
<body>

<form action="<?php echo $_SERVER['PHP_SELF'] ?>" method="GET">
Select your personality attribute:<br />
<select name="attributes" >
<option value="perky">Perky</option>
<option value="morose">Morose</option>
<option value="thinking">Thinking</option>
<option value="feeling">Feeling</option>
<option value="thrifty">Spend-thrift</option>
<option value="prodigal">Shopper</option>
</select>
<br>
<input type="submit" name="s" value="Record my personality!" />
</form>

<?php
    // Write PHP code here if needed
    if(isset($_GET['attributes'])) {
        $selected_attribute = $_GET['attributes'];
        echo "You selected: $selected_attribute";
    }
?>

</body>
</html>
