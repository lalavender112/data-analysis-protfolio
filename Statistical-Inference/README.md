# 🧑🏾‍⚖️ Jury Selection Bias Simulation — Swain v. Alabama (1965)


## 🎯 **Project Overview**

This project analyzes whether the racial makeup of the jury panel in Swain v. Alabama (1965) could have occurred by random chance.
Robert Swain, a Black man from Talladega County, Alabama, was convicted by an all-white jury.
Although 26% of eligible jurors in the county were Black, only 8 out of 100 men on Swain’s panel were Black.
Using simulation and bootstrapping, this project tests whether the jury selection process was likely to be fair.

## **🧮 Methodology**

Hypotheses:

Null Hypothesis (H₀): Jurors were selected randomly from a population that is 26% Black.

Alternative Hypothesis (H₁): The selection underrepresented Black jurors and was not random.

Steps performed:

Simulated 10,000 random jury panels of 100 men under fair selection (26% Black).

Calculated how often a panel with 8 or fewer Black jurors would occur by chance.

Used bootstrapping on Swain’s observed panel (8% Black) 10,000 times to estimate variability.

Compared the bootstrap and null distributions to visualize bias.

## **📊 Results**

The null distribution (🟡 yellow) centers near 26 Black jurors per panel, as expected under fair random selection.

The bootstrap distribution (🔵 blue) centers near 8, matching Swain’s actual panel.

The p-value for obtaining 8 or fewer Black jurors under fair selection is extremely small (close to 0).

## **✅ Interpretation:**
Such an extreme outcome is highly unlikely to occur by chance, providing strong evidence that the jury selection process was biased.

## **🧾 Conclusion**

The simulation provides strong statistical evidence that Swain’s jury was not randomly selected.
The significant underrepresentation of Black jurors indicates a systematic exclusion, not random variation, in the selection process.

## **🧰 Tools Used**

Python Libraries: NumPy, Data 8 Tables, Matplotlib

Techniques: Simulation, Hypothesis Testing, Bootstrapping, Confidence Intervals

## **📁 Files**

swain_simulation.ipynb — Jupyter Notebook containing the analysis and visualizations

README.md — Project documentation
