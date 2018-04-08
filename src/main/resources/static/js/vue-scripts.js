var navibar = new Vue({
    el: '#navibar',
    data: {
        isMenuOpen: false,
        isLoginOpen: false,
        userName: "<Имя пользователя после входа>"
    },
    methods: {
        buttonMenu: function (event) {
            if (this.isMenuOpen) this.isMenuOpen = false;
            else this.isMenuOpen = true;
        },
        buttonLogin: function (event) {
            if (this.isLoginOpen) {
                this.isLoginOpen = false;
            } else {
                this.isLoginOpen = true;
            }
        }
    }
})