using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.SessionState;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace a1
{
    public partial class A1 : System.Web.UI.Page
    {
        public class HospitalSystem
        {
            public string HospitalID { get; set; }
            public decimal Beds { get; set; }

            public HospitalSystem(string hospitalID, decimal beds)
            {
                HospitalID = hospitalID;
                Beds = beds;
            }

            public bool Appoint(decimal entry, HttpSessionState session)
            {
                if (entry <= 20 && entry + Beds <= 500)
                {
                    Beds += entry;
                    session["beds"] = Beds;
                    return true;

                }
                else
                {
                    return false;
                }
            }

            public bool Release(decimal entry, HttpSessionState session)
            {
                if (entry <= Beds)
                {
                    Beds -= entry;
                    session["beds"] = Beds;
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
                if (Session["hospital"] == null)
                {
                    Session["hospital"] = new HospitalSystem("123", 0);
                }
            }

        }



        protected void appoint_click(object sender, EventArgs e)
        {
            decimal entry = Convert.ToDecimal(newentry.Text);

            if (((HospitalSystem)Session["hospital"]).Appoint(entry, Session))
            {
                result.Text = "Success";

            }
            else
            {
                result.Text = "Failure";
            }

            if (Session["beds"] != null)
            {
                currentbed.Text = "Current Beds : " + Session["beds"].ToString();
            }
            else
            {
                currentbed.Text = "Current Beds : Not available";
            }
        }

        protected void release_click(object sender, EventArgs e)
        {
            decimal entry = Convert.ToDecimal(newentry.Text);

            if (((HospitalSystem)Session["hospital"]).Release(entry, Session))
            {
                result.Text = "Success";

            }
            else
            {
                result.Text = "Failure";
            }

            if (Session["beds"] != null)
            {
                currentbed.Text = "Current Beds : " + Session["beds"].ToString();
            }
            else
            {
                currentbed.Text = "Current Beds : Not available";
            }
        }
    }
}