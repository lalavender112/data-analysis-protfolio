# 📊 Statistical Inference Projects

This folder contains two simulation-based inference projects that apply hypothesis testing and bootstrapping techniques to real-world data.

---

## 🧑🏾‍⚖️ Jury Selection Bias Simulation — *Swain v. Alabama (1965)*

**Overview:**  
Analyzes whether the racial makeup of the jury panel in *Swain v. Alabama* could have occurred by chance.  
Although 26% of eligible jurors were Black, only 8 of 100 on the panel were — suggesting underrepresentation.

**Methods:**  
- Simulated 10,000 random jury panels under a fair selection model (26% Black).  
- Computed how often 8 or fewer Black jurors appeared by chance.  
- Used bootstrapping to estimate variability in the observed 8%.  

**Conclusion:**  
The p-value was near 0, providing strong evidence that the jury selection process was biased and not random.

📁 *File:* `swain_simulation.ipynb`

---

## 🍼 Maternal Age and Smoking: Effects on Infant Birth Outcomes

**Overview:**  
Explores how maternal factors — age and smoking status — affect infant birth weight and gestational duration.

**Methods:**  
- Performed simulation-based hypothesis testing for categorical data.  
- Built bootstrap confidence intervals for both proportions and means.  
- Compared smoking vs. non-smoking mothers using real birth data.

**Conclusion:**  
Maternal smoking is associated with lower birth weights, and bootstrapping methods provided robust confidence intervals for mean maternal age and outcome differences.

📁 *Files:*  
- `baby.csv`  
- `maternal_age_smoke.pdf`  
- `maternal_age_analysis.ipynb` *(to be added)*

---

## 🧰 Tools & Techniques
- **Python Libraries:** NumPy, Matplotlib, datascience (UC Berkeley Data 8 library)  
- **Statistical Methods:** Simulation, Hypothesis Testing, Bootstrapping, Confidence Intervals  

---

## 🧑‍💻 Author
**Melissa Chen**  
Data Science & Economics | UNC-Chapel Hill  
📫 [Your Email or GitHub Profile Link]
