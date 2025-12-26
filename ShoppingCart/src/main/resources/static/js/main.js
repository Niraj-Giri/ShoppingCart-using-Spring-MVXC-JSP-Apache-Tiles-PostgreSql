// Auto-hide flash messages
setTimeout(function () {
    var msg = document.getElementById("flash-msg");
    if (msg) {
        msg.style.display = "none";
    }
}, 2000);
