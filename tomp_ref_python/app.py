import connexion

app = connexion.FlaskApp(__name__, specification_dir="specification/")
app.add_api("TOMP-API.yaml")
app.run(port=8080)
