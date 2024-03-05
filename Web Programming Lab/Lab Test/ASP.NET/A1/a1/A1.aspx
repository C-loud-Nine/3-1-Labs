<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="A1.aspx.cs" Inherits="a1.A1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Hospital Management System</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h1>Hospital Mang. System</h1>
            <asp:TextBox ID="newentry" runat="server" type="number" placeholder="new" required></asp:TextBox>
            <br />
            <asp:Button ID="add" runat="server" Text="Appoint" OnClick="appoint_click" />
            <asp:Button ID="rel" runat="server" Text="Release" OnClick="release_click" />
            <br />

            <asp:Label ID="result" runat="server"></asp:Label>
            <br />

            <asp:Label ID="currentbed" runat="server"></asp:Label>

        </div>
    </form>
</body>
</html>
