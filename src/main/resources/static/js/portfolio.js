var navibar = new Vue({
    el: '#content',
    data: {
        isPortfolioOpen: false,
        //userName: "<Имя пользователя после входа>"
    },
    methods: {
        buttonPortfolio: function (event) {
            if (this.isPortfolioOpen) {
                this.isPortfolioOpen = false;
            } else {
                this.isPortfolioOpen = true;
            }
        }
    }
})