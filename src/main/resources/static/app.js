const myApp = {

    // Préparation des données
    data() {
        console.log("data");
        return {
            cvs: [],
            cv : null,
            activities: [],
            persons: [],
            axios: null,
            router:null
        }
    },

    // Mise en place de l'application
    mounted() {
        console.log("Mounted ");
        this.axios = axios.create({
            baseURL: 'http://localhost:8081/api/',
            timeout: 1000,
            headers: {'Content-Type': 'application/json'},
        });

        this.getActivities();
        this.getListOfPerson();
        this.getCvActivities();
        this.getListeOfCV();

    },

    methods: {

        getActivities: function () {
            this.axios.get("activities")
                .then(rep => {
                        console.log("get activities done");
                        this.activities = rep.data
                    }
                )
        },


        getListeOfCV: function () {
            this.axios.get("cvs")
                .then(rep => {
                        console.log("get list of Cv done");
                        this.cvs = rep.data
                    }
                )
        },

        getCvActivities: function (id) {
            this.axios.get("cv/" + id)
                .then(rep => {
                    console.log("show cv" + id + " done");
                    this.cv = rep.data;
                });
        },

        getListOfPerson : function (){
            this.axios.get("persons")
                .then(rep => {
                    console.log("get list of person done !")
                    this.persons=rep.data;
                })
        }
    }
}

Vue.createApp(myApp).mount('#myApp');