<html>
<head><title>Calculator</title></head>
<body>


<form action="<?php echo $_SERVER['PHP_SELF'] ?>" method="POST">
Input Number 1 : <input type="number" name="num1" /> <br />
Input Number 2 : <input type="number" name="num2" /> <br />
<br/>
<input type="submit" value=" PLUS + " name="add" />
<input type="submit" value=" MINUS - " name="substract" />
<input type="submit" value=" MULTIPLY * " name="multiply" />
<input type="submit" value=" DIVIDE / " name="divide" />
</form>



<?php

if($_SERVER['REQUEST_METHOD'] == 'POST'){ 
      $val1 = $_POST['num1'];
      $val2 = $_POST['num2'];
      
      
    if(isset($_POST['add'])){
        $result = $val1 + $val2;
        echo "Result : " . $result;
    }
    else if(isset($_POST['substract'])){
        $result = $val1 - $val2;
        echo "Result : " . $result;
    }
    else if(isset($_POST['multiply'])){
        $result = $val1 * $val2;
        echo "Result : " . $result;
    }
    else if(isset($_POST['divide'])){
        $result = $val1 / $val2;
        echo "Result : " . $result;
    }
}
else {
   die("This script only works with GET and POST requests.");
 }
?>

</body>
</html>