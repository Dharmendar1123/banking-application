// LOGIN CUSTOMER
function login_cust() {
  var email = document.getElementById("email").value;
  var password = document.getElementById("password").value;

  var login_data = {
    emailId: email,
    password: password,
  };

  $.ajax({
    type: "POST",
    url: "http://localhost:8080/customer/auth/loginCustomer",
    contentType: "application/json",
    data: JSON.stringify(login_data),
    dataType: "json",

    success: function (data) {
      accountNumber = JSON.stringify(data.customerEntity.accountNumber).replace(
        /^"(.*)"$/,
        "$1"
      );
      customerId = JSON.stringify(data.customerEntity.customerId);
      sessionStorage.setItem("accountNumber", accountNumber);
      sessionStorage.getItem("accountNumber");
      sessionStorage.setItem("customerId", customerId);
      sessionStorage.setItem(
        "customerId",
        JSON.stringify(data.customerEntity.customerId).replace(/^"(.*)"$/, "$1")
      );
      sessionStorage.setItem(
        "emailId",
        JSON.stringify(data.customerEntity.emailId).replace(/^"(.*)"$/, "$1")
      );
      sessionStorage.setItem(
        "firstName",
        JSON.stringify(data.customerEntity.firstName).replace(/^"(.*)"$/, "$1")
      );
      sessionStorage.setItem(
        "middleName",
        JSON.stringify(data.customerEntity.middleName).replace(/^"(.*)"$/, "$1")
      );
      sessionStorage.setItem(
        "lastName",
        JSON.stringify(data.customerEntity.lastName).replace(/^"(.*)"$/, "$1")
      );
      sessionStorage.setItem(
        "address",
        JSON.stringify(data.customerEntity.address).replace(/^"(.*)"$/, "$1")
      );
      $("#senderAccountNumber").val(sessionStorage.getItem("accountNumber"));
      console.log(sessionStorage.getItem("emailId"));
      window.location.href = "./pages/home.html";
    },

    error: function (error) {
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: error.responseJSON.message,
      });
      console.log(error);
    },
  });
}

$(document).ready(function () {
  console.log(sessionStorage.getItem("accountNumber"));
  $("#accountNumber").val(sessionStorage.getItem("accountNumber"));
  $("#customerId").val(sessionStorage.getItem("customerId"));
  $("#firstName").val(sessionStorage.getItem("firstName"));
  $("#middleName").val(sessionStorage.getItem("middleName"));
  $("#lastName").val(sessionStorage.getItem("lastName"));
  $("#address").val(sessionStorage.getItem("address"));
  $("#email").val(sessionStorage.getItem("emailId"));
});

function register_cust() {
  var firstName = document.getElementById("firstName").value;
  var middleName = document.getElementById("middleName").value;
  var lastName = document.getElementById("lastName").value;
  var emailId = document.getElementById("email").value;
  var password = document.getElementById("password").value;
  var aadharNumber = document.getElementById("aadharNumber").value;
  var panNumber = document.getElementById("panNumber").value;
  var mobileNumber = document.getElementById("mobileNumber").value;
  var dateOfBirth = document.getElementById("dateOfBirth").value;
  var address = document.getElementById("address").value;

  var register_data = {
    firstName: firstName,
    middleName: middleName,
    lastName: lastName,
    aadharNumber: aadharNumber,
    panNumber: panNumber,
    dateOfBirth: dateOfBirth,
    address: address,
    mobileNumber: mobileNumber,
    emailId: emailId,
    password: password,
  };

  $.ajax({
    type: "POST",
    url: "http://localhost:8080/customer/auth/registerCustomer",
    contentType: "application/json",
    data: JSON.stringify(register_data),
    dataType: "json",

    success: function () {
      window.location.href = "../index.html";
    },

    error: function (error) {
      console.log(error);
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: error.responseJSON.message,
      });
    },
  });
}

function update_profile() {
  var customerId = document.getElementById("customerId").value;
  var firstName = document.getElementById("firstName").value;
  var middleName = document.getElementById("middleName").value;
  var lastName = document.getElementById("lastName").value;
  var address = document.getElementById("address").value;

  var profileUpdate_data = {
    customerId: customerId,
    firstName: firstName,
    middleName: middleName,
    lastName: lastName,
    address: address,
  };

  $.ajax({
    type: "POST",
    url: "http://localhost:8080/customer/auth/updateCustomer",
    contentType: "application/json",
    data: JSON.stringify(profileUpdate_data),
    dataType: "json",

    success: function () {
      window.location.href = "./home.html";
      sessionStorage.setItem(
        "firstName",
        JSON.stringify(data.customerEntity.firstName).replace(/^"(.*)"$/, "$1")
      );
      sessionStorage.setItem(
        "middleName",
        JSON.stringify(data.customerEntity.middleName).replace(/^"(.*)"$/, "$1")
      );
      sessionStorage.setItem(
        "lastName",
        JSON.stringify(data.customerEntity.lastName).replace(/^"(.*)"$/, "$1")
      );
      sessionStorage.setItem(
        "address",
        JSON.stringify(data.customerEntity.address).replace(/^"(.*)"$/, "$1")
      );
    },

    error: function (error) {
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: error.responseJSON.message,
      });
    },
  });
}

function update_password() {
  var emailId = document.getElementById("email").value;
  var newPassword = document.getElementById("newPassword").value;
  var confirmPassword = document.getElementById("confirmPassword").value;
  var oldPassword = document.getElementById("oldPassword").value;

  var passwordUpdate_data = {
    emailId: emailId,
    newPassword: newPassword,
    confirmPassword: confirmPassword,
    oldPassword: oldPassword,
  };

  $.ajax({
    type: "POST",
    url: "http://localhost:8080/customer/auth/updatePassword",
    contentType: "application/json",
    data: JSON.stringify(passwordUpdate_data),
    dataType: "json",

    success: function () {
      window.location.href = "./home.html";
    },

    error: function (error) {
      console.log(error);
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: error.responseJSON.message,
      });
    },
  });
}

function send_otp() {
  console.log(`sessionStorage: ${JSON.stringify(sessionStorage)}`);
  var sendOTP = {
    emailId: sessionStorage.getItem("emailId"),
  };

  $.ajax({
    type: "POST",
    url: "http://localhost:8080/customer/auth/sendOTP",
    contentType: "application/json",
    data: JSON.stringify(sendOTP),
    dataType: "json",

    success: function (data) {},

    error: function (error) {
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: error.responseJSON.message,
      });
    },
  });
}

function verify_otp() {
  var verifyOTP = document.getElementById("verifyOTP").value;
  var sendOTP = {
    customerId: sessionStorage.getItem("customerId"),
    otp: verifyOTP,
  };
  console.log(sessionStorage.getItem("customerId"));

  $.ajax({
    type: "POST",
    url: "http://localhost:8080/customer/auth/verifyOtp",
    contentType: "application/json",
    data: JSON.stringify(sendOTP),
    dataType: "json",

    success: function (data) {
      console.log(document.getElementById("receiverAccountNumber").value);
      transfer_money();
    },

    error: function (error) {
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: error.responseJSON.message,
      });
    },
  });
}

$(document).ready(function () {
  console.log(sessionStorage.getItem("accountNumber"));
  $("#accountNumber").val(sessionStorage.getItem("accountNumber"));
  $("#senderAccountNumber").val(sessionStorage.getItem("accountNumber"));
  console.log(Object.keys(sessionStorage));
});

function add_money() {
  var accountNumber = document.getElementById("accountNumber").value;
  var amount = document.getElementById("amount").value;

  var amount_data = {
    accountNumber: accountNumber,
    accountBalance: amount,
  };

  $.ajax({
    type: "POST",
    url: "http://localhost:8080/customer/transaction/addBalance",
    contentType: "application/json",
    data: JSON.stringify(amount_data),
    dataType: "json",

    success: function () {
      window.location.href = "./home.html";
    },

    error: function (error) {
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: error.responseJSON.message,
      });
    },
  });
}

function transfer_money() {
  var senderAccount = document.getElementById("senderAccountNumber").value;
  var receiverAccount = document.getElementById("receiverAccountNumber").value;
  var amount = document.getElementById("amount").value;
  var branchName = document.getElementById("branchName").value;
  var ifsc = document.getElementById("ifsc").value;
  var transactionPin = document.getElementById("transactionPin").value;

  var transfer_data = {
    accountNumber: senderAccount,
    userAccountNumber: receiverAccount,
    amount: amount,
    branchName: branchName,
    ifsc: ifsc,
    transactionPin: transactionPin,
  };

  $.ajax({
    type: "POST",
    url: "http://localhost:8080/customer/transaction/transferMoney",
    contentType: "application/json",
    data: JSON.stringify(transfer_data),
    dataType: "json",

    success: function () {
      window.location.href = "./home.html";
    },

    error: function (error) {
      console.log(error);
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: error.responseJSON.message,
      });
    },
  });
}

function logout() {
  sessionStorage.clear();

  window.location.href = "../index.html";
}
