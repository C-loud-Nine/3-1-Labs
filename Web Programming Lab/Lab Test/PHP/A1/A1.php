<?php

session_start();

class HospitalSystem {
    private $hospitalID;
    private $beds;

    public function __construct($hospitalID, $beds){
        $this->hospitalID = $hospitalID;
        $this->beds = $beds;
    }

    public function appoint($new){
        if($new <= 20 && $new + $this->beds <= 500){
            $this->beds += $new;
            $_SESSION['beds'] = $this->beds;
            return true;
        } else {
            return false;
        }
    }

    public function release($new){
        if($new <= $this->beds){
            $this->beds -= $new;
            $_SESSION['beds'] = $this->beds;
            return true;
        } else {
            return false;
        }
    }

    public function showBeds(){
        return $this->beds;
    }
}

if($_SERVER["REQUEST_METHOD"] == "POST"){

    if(!isset($_SESSION['hospitalSystem'])){
        $_SESSION['hospitalSystem'] = new HospitalSystem('123456789', 0);
    }

    if(isset($_POST['add'])){
        $new = $_POST['new'];
        if($_SESSION['hospitalSystem']->appoint($new)){
            echo "Appointment successful!";
        } else {
            echo "Appointment limit exceeded!";
        }
    } elseif(isset($_POST['rel'])){
        $new = $_POST['new'];
        if($_SESSION['hospitalSystem']->release($new)){
            echo "Release successful!";
        } else {
            echo "Insufficient beds!";
        }
    }
}

?>


<html>
<head>
    <title>Hospital Management System</title>
</head>
<body>

<form action="" method="POST">
    No of Beds : <input type="number" name="new" placeholder="no of beds" required><br>

    <input type="submit" name="add" value="Appoint">
    <input type="submit" name="rel" value="Release">

    Current Available Beds : <?php echo isset($_SESSION['beds']) ? $_SESSION['beds'] : 0; ?>

</form>
</body>
</html>
