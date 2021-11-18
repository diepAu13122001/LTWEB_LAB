<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lab5_Bai3_19130038</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<div class="container">
    <div class="wrap">
        <form action="SigninServlet" class="form validate-form">
				<span class="form-title">
					Contact Us
				</span>

            <div class="wrap-input1 validate-input bg1" data-validate="Please Type Your Name">
                <span class="label-input1">FULL NAME *</span>
                <input class="input1" type="text" name="name" placeholder="Enter Your Name">
            </div>

            <div class="wrap-input1 validate-input bg1 rs1-wrap-input1" data-validate="Enter Your Email (e@a.x)">
                <span class="label-input1">Email *</span>
                <input class="input1" type="text" name="email" placeholder="Enter Your Email ">
            </div>

            <div class="wrap-input1 bg1 rs1-wrap-input1">
                <span class="label-input1">Phone</span>
                <input class="input1" type="text" name="phone" placeholder="Enter Number Phone">
            </div>

            <div class="wrap-input1 input100-select bg1">
                <span class="label-input1">Needed Services *</span>
                <div>
                    <select class="js-select2" name="service">
                        <option>Please chooses</option>
                        <option>option 1</option>
                        <option>option 2</option>
                        <option>option 3</option>
                    </select>
                </div>
            </div>

            <div class="wrap-input1 validate-input bg0 rs1-alert-validate" data-validate="Please Type Your Message">
                <span class="label-input1">Message</span>
                <textarea class="input1" name="message" placeholder="Your message here..."></textarea>
            </div>

            <script src="https://use.fontawesome.com/3168ca345a.js"></script>
            <div class="submit_btn">
                <button class="submit_btn">
						<span>
							Submit
							<i class="fa fa-long-arrow-right m-l-7"></i>
						</span>
                </button>
            </div>
        </form>
    </div>
</div>

<script src="js/main.js"></script>
</body>
</html>