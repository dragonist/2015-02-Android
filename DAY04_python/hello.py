from flask import Flask, request, send_file;
from flaskext.mysql import MySQL;
import json;
import os;
# from flask import render_template

UPLOAD_FOLDER = "/Users/igyeonglyun/tempErin/"
app = Flask(__name__);
mysql = MySQL();

app.config['MYSQL_DATABASE_USER'] = 'root';
app.config['MYSQL_DATABASE_PASSWORD'] = '1234';
app.config['MYSQL_DATABASE_DB'] = 'nextgram';

mysql.init_app(app);


ALLOWED_EXTENSIONS = set(['png', 'jpg', 'jpeg', 'gif'])
def allowd_file(filename):
	return '.' in filename and filename.rsplit('.',1)[1] in ALLOWED_EXTENSIONS


@app.route("/")
def helloWorld():
	return "helloWorld";
	

# @app.route("/index")
# def showPage(pages=None):
# 	return render_template('index.html', pagesData = pages);

# see all
@app.route("/loadData")
def loadData():
	cursor = mysql.connect().cursor();
	cursor.execute("select * from next_android_nextagram")

	result = []
	columns = tuple([d[0] for d in cursor.description])

	for row in cursor:
		result.append(dict(zip(columns, row)))

	# print(result);

	return json.dumps(result);

@app.route("/upload", methods=["POST"])
# @app.route("/upload")
def upload():
	if request.method == 'POST':
		title = request.form['title']
		writer = request.form['writer']
		id = request.form['id']
		content = request.form['content']
		writeDate = request.form['writeDate']
		imgName = request.form['imgName']

		file = request.files['uploadedfile']
		path = UPLOAD_FOLDER + file.filename;

		if file and allowd_file(file.filename):
			file.save(path)

			con = mysql.connect();
			cursor = con.cursor();

			query = "insert into next_android_nextagram \
			(Title, Writer, Id, Content, WriteDate, ImgName) values \
			('"+title+"', '"+writer+"', '"+id+"', '"+content+"', \
				'"+writeDate+"', '"+imgName+"')"
			cursor.execute(query);
			con.commit();

			return "ok";
	return "error";



@app.route("/image/<fileName>", methods=["GET", "POST"])
def loadImage(filename):
	print("fileName: "+filename);
	return send_file(UPLOAD_FOLDER+filename, mimetype='image');


if __name__=="__main__":
	app.run(debug=True, host='0.0.0.0', port=5009);