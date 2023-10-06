function loaded() {
    console.log("Something has loaded");
    console.log("Database initalised");
}

function Login(element) {

    console.log(document.forms["login"]["username"].value);
    if (document.forms["login"]["username"].value == "test") {
        console.log("OMGEJGKEG");
        // this works: window.location.href = "./home.html";
    }
}

function mobileNavClicked(element) {
    const navClassList = document.getElementById("navItems").classList;
    if (navClassList.contains("hidden")) {
        navClassList.remove("hidden");
    } else {
        navClassList.add("hidden");
    }
    navClassList.add ("vertical") ? !(navClassList.contains("vertical")) : null
}