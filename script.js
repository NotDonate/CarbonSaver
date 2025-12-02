function sendEmail(){
    const templateParams = {
        name: document.querySelector("#name").value,
        email: document.querySelector("#email").value,
        subject: "User Feedback",
        message: document.querySelector("#message").value,
    };

    emailjs
        .send("service_fo5hk2a", "template_j7wu0oq", templateParams)
         .then(() => alert("Email sent!!"))
         .catch((err) => {
            console.error("EmailJS error:", err);
            alert("Email not sent!");
         });

}