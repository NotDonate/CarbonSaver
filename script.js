function sendFeedbackEmail(){
    const templateParams = {
        name: document.querySelector("#name").value,
        email: document.querySelector("#email").value,
        subject: "User Feedback",
        message: document.querySelector("#message").value,
        rating: rating
    };

    emailjs
        .send("service_fo5hk2a", "template_j7wu0oq", templateParams)
         .then(() => alert("Email sent!!"))
         .catch((err) => {
            console.error("EmailJS error:", err);
            alert("Email not sent!");
         });

}
function sendOptionEmail() {

    const selectedOption = document.getElementById("selectedOption").value;
    const email = document.getElementById("emailname").value;

    const optionDescriptions = {
        SolarPanels: "Install solar panels to generate renewable electricity and reduce long-term energy costs.",
        LEDs: "Switch to LED bulbs to reduce electricity use with a cheap and easy home upgrade.",
        Insulation: "Improve wall, loft, or floor insulation to reduce heat loss and improve energy efficiency.",
        HeatedFloors: "Underfloor heating can improve efficiency but installation is more costly.",
        SwitchingTravel: "Use lower-carbon transport options such as walking, cycling, or public transport.",
        ElectricMeter: "Use a smart meter to monitor energy usage and reduce unnecessary electricity consumption."
    };

    const templateParams = {
        option_name: selectedOption,
        option_description: optionDescriptions[selectedOption],
        to_email: email
    };

    emailjs.send(
        "service_fo5hk2a",
        "template_5jldjxu",
        templateParams
    ).then(
        function () {
            alert("Email sent!");
        },
        function (error) {
            console.error("FAILED...", error);
        }
    );
}