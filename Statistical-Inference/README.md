# 📊 Statistical Inference Projects

This folder contains three simulation-based inference projects that apply hypothesis testing, A/B testing, and bootstrapping techniques to real-world data.

---

## Jury Selection Bias Simulation — *Swain v. Alabama (1965)*

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

## Maternal Age and Smoking: Effects on Infant Birth Outcomes

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
- `maternal_age_analysis.ipynb`

---

## A/B Testing Simulation — Dolphin Therapy and Depression

**Overview:**  
Uses an A/B testing framework to test whether swimming with dolphins improves symptoms of depression.  
In a randomized controlled trial, 10 of 13 patients who swam with dolphins showed improvement, compared to 3 of 12 who swam without them.

**Methods:**  
- Randomly assigned participants to two treatment groups (dolphin vs. control).  
- Simulated 10,000 random reassignments to estimate how often such a difference could occur by chance.  
- Conducted a simulation-based hypothesis test comparing improvement proportions.  

**Conclusion:**  
The p-value (≈ 0.013) indicates the observed difference is highly unlikely under random assignment, suggesting a real therapeutic benefit of dolphin-assisted therapy.

📁 *File:* `dolphin_ab_test.ipynb`


---
Death Penalty and Murder Rates — Randomization Simulation
**Overview**

This analysis explores whether U.S. states with the death penalty have lower murder rates than those without, using 1971 data.

**Hypotheses**

H₀: Murder rates are the same in states with and without the death penalty.

H₁: States with the death penalty have lower murder rates.

**Method**

A randomization (permutation) test shuffles “death penalty” labels among states to simulate what differences would look like under random chance.

**Conclusion**

The observed difference in mean murder rates was not likely due to random variation, suggesting an association between the death penalty and higher murder rates.

## 🧰 Tools & Techniques
- **Python Libraries:** NumPy, Matplotlib, datascience (UC Berkeley Data 8 library)  
- **Statistical Methods:** Simulation, A/B Testing, Hypothesis Testing, Bootstrapping, Confidence Intervals  

---

## 🧑‍💻 Author
**Melissa Chen**  
Data Science & Economics | UNC-Chapel Hill  
📫 [Your Email or GitHub Profile Link]
