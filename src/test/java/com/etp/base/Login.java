package com.etp.base;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    plugin = {
	        "pretty",
	        "html:target/cucumber/result",
	        "json:target/cucumber.json",
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	    },
	    features = {
	   "Feature/a_unifylogin.feature",
//	   "Feature/basicpromo.feature",
	   "Feature/c_shiftbegin.feature",
//	   "Feature/d_productscan.feature",
//	   "Feature/e_billwithwalkin.feature",
//	   "Feature/f_discountpromo.feature",
///	   "Feature/h_billwithreference.feature",
	//   "Feature/g_tenderpromotion.feature",  
	//   "Feature/i_billwithoutreference.feature",
	//   "Feature/j_billcancellation.feature",
//	   "Feature/k_endlessaisle.feature",
//	   "Feature/l_advanceorder.feature",
//	   "Feature/p_dualscreen.feature",
//     "Feature/r_lift.feature",
//     "Feature/s_drop.feature",
//	   "Feature/m_onlineorder.feature",
//	   "Feature/n_indiagst.feature",      	   
//	   "Feature/w_partialorderreturn.feature",
//	   "Feature/t_billwithcharges.feature",
//	   "Feature/u_shiftend.feature",
//	   "Feature/x_eod.feature"
//	   "Feature/y_clienttelling.feature"
	    },
	    glue = {"com.etp.stepdefinition"}
	)


public class Login{

}
