using System;
using System.Web;
using System.Web.SessionState;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Lab_Test
{
    public partial class Bank : System.Web.UI.Page
    {
        public class BankAccount
        {
            public string AccountNumber { get; set; }
            public decimal Balance { get; set; }

            public BankAccount(string accountNumber, decimal balance)
            {
                AccountNumber = accountNumber;
                Balance = balance;
            }

            public bool Deposit(decimal amount, HttpSessionState session)
            {
                if (amount <= 1000)
                {
                    Balance += amount;
                    session["balance"] = Balance;
                    return true;
                }
                else
                {
                    return false;
                }
            }

            public bool Withdraw(decimal amount, HttpSessionState session)
            {
                if (amount <= Balance)
                {
                    Balance -= amount;
                    session["balance"] = Balance;
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Initialize BankAccount object and session
                if (Session["bankAccount"] == null)
                {
                    Session["bankAccount"] = new BankAccount("123456789", 0);
                }
            }
        }

        protected void DepositButton_Click(object sender, EventArgs e)
        {
            decimal amount = Convert.ToDecimal(AmountTextBox.Text);
            if (((BankAccount)Session["bankAccount"]).Deposit(amount, Session))
            {
                ResultLabel.Text = "Deposit successful!";
            }
            else
            {
                ResultLabel.Text = "Deposit limit exceeded!";
            }

            // Display current balance
            CurrentBalanceLabel.Text = "Current Balance: " + Session["balance"].ToString();
        }

        protected void WithdrawButton_Click(object sender, EventArgs e)
        {
            decimal amount = Convert.ToDecimal(AmountTextBox.Text);
            if (((BankAccount)Session["bankAccount"]).Withdraw(amount, Session))
            {
                ResultLabel.Text = "Withdrawal successful!";
            }
            else
            {
                ResultLabel.Text = "Insufficient balance!";
            }

            // Display current balance
            CurrentBalanceLabel.Text = "Current Balance: " + Session["balance"].ToString();
        }
    }
}
