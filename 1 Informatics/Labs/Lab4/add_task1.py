from json2xml import json2xml
from json2xml.utils import readfromjson

def convert_json_to_xml(json_file_path):
        with open("data/out1.xml", "w", encoding="utf-8") as xml_file:
            xml_file.write(json2xml.Json2xml(readfromjson(json_file_path)).to_xml())


convert_json_to_xml("data/in.json")