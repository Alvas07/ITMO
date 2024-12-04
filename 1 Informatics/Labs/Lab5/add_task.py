import matplotlib.pyplot as plt
import pandas as pd


df = pd.read_csv("data.csv", sep=";")
fig, ax = plt.subplots(1, 4,figsize=(16, 4))
df.groupby(['<DATE>']).boxplot(column="<OPEN>,<HIGH>,<LOW>,<CLOSE>".split(","), ax=ax)
plt.show()
