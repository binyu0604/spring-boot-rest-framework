<script type="text/javascript">
    if (window.top == window) {
        window.location.href = "/login.html";
    } else {
        window.top.doLogin(function () {
            window.location.reload();
        });
    }
</script>