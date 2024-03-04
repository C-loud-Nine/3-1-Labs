<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Bank.aspx.cs" Inherits="Lab_Test.Bank" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Bank Acc. Form</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h1>Bank Account Form</h1>
            <asp:TextBox ID="AmountTextBox" runat="server" type="number" placeholder="amount" required></asp:TextBox>
            <br />
            <asp:Button ID="DepositButton" runat="server" Text="Deposit" OnClick="DepositButton_Click" />
            <asp:Button ID="WithdrawButton" runat="server" Text="Withdraw" OnClick="WithdrawButton_Click" />
            <br />
            <asp:Label ID="ResultLabel" runat="server"></asp:Label>
            <br />
            <asp:Label ID="CurrentBalanceLabel" runat="server"></asp:Label>
        </div>
    </form>
</body>
</html>
