import pandas as pd
import json


def convert_json_to_csv(json_file_path):
    with open(json_file_path, "r", encoding="utf-8") as json_file:
        data = json.loads(json_file.read())

    df = pd.json_normalize(data)

    df.to_csv("data/out5.csv", encoding="utf-8")


convert_json_to_csv("data/in.json")
