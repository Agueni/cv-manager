const myApp = {

    // Préparation des données
    data() {
        console.log("data");
        return {
            cvs: [],
            cv : null,
            activity: null,
            person:null,
            firstName:"",
            lastName:"",
            birthday:"",
            email:"",
            webSite:"",
            editable:null,
            activities: [],
            persons: [],
            errors:[],
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
        this.getActivityDetails();
        console.log(this.editable);
        this.getPersonDetails();



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

        getActivityDetails: function (id) {

            console.log(id);
            this.axios.get("activity/" + id)

                .then(rep => {
                    console.log("show activity" + id + " done");
                    this.editable= rep.data;
                    console.log(this.editable);

                });
        },

        getListOfPerson : function (){
            this.axios.get("persons")
                .then(rep => {
                    console.log("get list of person done !")
                    this.persons=rep.data;
                })
        },

        editActivity: function (editable){

            let data = {
                id:editable.id,
                year: editable.year,
                nature:editable.nature,
                description:editable.description,
                webSite:editable.webSite
            };

            this.axios.put("updateActivity",data)

                .then(rep=> {
                    console.log("update activity done !")
                    console.log(rep.data);
                    this.errors=rep.data;
                    if(Object.keys(this.errors).length==0){

                        this.getActivityDetails(editable.id);
                        this.getActivities();
                        console.log(rep.data);
                        window.location.href("cvs");
                    }

                })

        },


        getPersonDetails: function (id) {
            this.axios.get("person/" + id)
                .then(rep => {
                    console.log("show person" + id + " done");
                    this.person = rep.data;

                });
        },


        createPerson: function (e){
            e.preventDefault();

            this.axios.post("newPerson", {
                firstName: this.firstName,
                lastName: this.lastName,
                birthday: this.birthday,
                email: this.email,
                webSite: this.webSite
            })
                .then(r=> {
                    console.log("person created !")
                })

                .catch(error => {
                        this.errors = error.message;
                        console.error("There was an error!", error);
                    });

        },

        userAuthentification: function (){



        },
    }
}

Vue.createApp(myApp).mount('#myApp');