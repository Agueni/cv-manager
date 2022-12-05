const login = {

    // Préparation des données
        data () {
            console.log("data");
            return {
                axios: null,
                mail: '',
                password: '',
                token:'',

            }

        },


    // Mise en place de l'application
    mounted() {
        console.log("Mounted ");
        this.axios = axios.create({
            baseURL: 'http://localhost:8081/secu-users',
            timeout: 1000,
            headers: {'Content-Type': 'application/json'},
        });


    },

    methods: {

        async handleSubmit () {
            const auth = await axios.post('/login',{
                mail: this.mail,
                password: this.password
            })
                .then(res=>{
                    console.log(res.data);

                    window.localStorage.setItem('token',this.token);

                })
                .catch((error) => {
                    alert("Vous n'ête pas inscrit");
                    console.log(error);
                });
        },


    }



}
Vue.createApp(login).mount('#login');