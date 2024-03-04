<?php

session_start();

class BankAccount {
    private $accountNumber;
    private $balance;

    public function __construct($accountNumber, $balance) {
        $this->accountNumber = $accountNumber;
        $this->balance = $balance;
    }

    public function deposit($amount) {
        if ($amount <= 1000) {
            $this->balance += $amount;
            $_SESSION['balance'] = $this->balance;
            return true;
        } else {
            return false;
        }
    }

    public function withdraw($amount) {
        if ($amount <= $this->balance) {
            $this->balance -= $amount;
            $_SESSION['balance'] = $this->balance;
            return true;
        } else {
            return false;
        }
    }

    public function showBalance() {
        return $this->balance;
    }
}

// Check if form is submitted
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Create or retrieve BankAccount object from session
    if (!isset($_SESSION['bankAccount'])) {
        // Initialize BankAccount object with account number and balance
        $_SESSION['bankAccount'] = new BankAccount('123456789', 0);
    }

    // Perform deposit or withdrawal based on button clicked
    if (isset($_POST['deposit'])) {
        $amount = $_POST['amnt'];
        if ($_SESSION['bankAccount']->deposit($amount)) {
            echo "Deposit successful!";
        } else {
            echo "Deposit limit exceeded!";
        }
    } elseif (isset($_POST['withdraw'])) {
        $amount = $_POST['amnt'];
        if ($_SESSION['bankAccount']->withdraw($amount)) {
            echo "Withdrawal successful!";
        } else {
            echo "Insufficient balance!";
        }
    }
}

?>

<html>
<head>
    <title>Bank Acc. Form</title>
</head>
<body>

<form action="" method="POST">
    Amount : <input type="number" name="amnt" placeholder="amount" required>

    <input type="submit" value=" Deposit " name="deposit" />
    <input type="submit" value=" Withdraw " name="withdraw" />

    Current Balance : <?php echo isset($_SESSION['balance']) ? $_SESSION['balance'] : 0; ?>

</form>

</body>
</html>
