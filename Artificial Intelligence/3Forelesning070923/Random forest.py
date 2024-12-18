import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier  # Import RandomForestClassifier
from sklearn.metrics import accuracy_score
import matplotlib.pyplot as plt

# Step 1: Load the data
data = pd.read_csv("titanic.csv")

# Step 2: Preprocess the data
# Encoding categorical variable "Sex" into numerical values
data["Sex"] = data["Sex"].map({"female": 0, "male": 1})

# Handling missing values
data["Age"].fillna(data["Age"].mean(), inplace=True)

# Step 3: Split the data into features (X) and target variable (y)
X = data[["Age", "Pclass", "Sex"]]
y = data["Survived"]

# Step 4: Split the data into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=22)

# Step 5: Create and train the Random Forest classifier (replace DecisionTreeClassifier)
classifier = RandomForestClassifier(n_estimators=100, random_state=42)  # Use RandomForestClassifier

classifier.fit(X_train, y_train)

# Step 6: Make predictions on the test set
y_pred = classifier.predict(X_test)

# Step 7: Evaluate the accuracy of the model
accuracy = accuracy_score(y_test, y_pred)
print("Accuracy:", accuracy)

# Step 8: Visualize the Random Forest
# Note: Random Forests consist of multiple decision trees, and visualizing all of them is not practical.
# You can still visualize individual decision trees within the Random Forest if needed.

# Step 9: Make predictions on new, unseen data
new_data = pd.DataFrame([[50, 1, 1]], columns=["Age", "Pclass", "Sex"])
predictions = classifier.predict(new_data)
predictions_mapped = ["Survived" if pred == 1 else "Dead" for pred in predictions]

print("Predictions:", predictions_mapped)
