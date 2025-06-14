from flask import Flask, request, jsonify
import pickle
from textblob import TextBlob
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

@app.route('/analyze', methods=['GET'])
def analyze():
    text = request.args.get('text')
    blob = TextBlob(text)
    sentiment = blob.sentiment.polarity
    if sentiment > 0:
        return "positive"
    elif sentiment < 0:
        return "negative"
    else:
        return "neutral"

if __name__ == '__main__':
    app.run(port=5000)
