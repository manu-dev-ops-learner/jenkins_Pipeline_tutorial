#Import
from plus_ou_moins import plus_ou_moins
from flask import Flask


#Flask instance
app = Flask(__name__)

#Flask decorator
@app.route("/")
def index():
    return "This is my first Flask app, you will see funny content in following days ! " "\N{winking face}" 


@app.route("/hi")
def who():
    return "Who are you ?"


@app.route("/hi/<username>")
def great(username):
    return f"Hi, {username} ! "

@app.route("/moreorlessgame/")
def more_or_less_game():
    plus_ou_moins()

if __name__ == "__main__":
     app.run(debug=True, host='0.0.0.0')

