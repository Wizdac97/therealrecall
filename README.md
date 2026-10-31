# SMLE Recall Pro — Android Medical MCQ App

This repository is the destination for the Android project supplied in `SMLE_Recall_Pro_Android_GitHub(1).zip`. **The project source files still need to be imported**; this README is the initial repository setup.

## App contents

The supplied project is a native Android app whose question interface runs locally in an Android WebView. Its archive contains 525 supplied MCQs across Pediatrics, Internal Medicine, Obstetrics & Gynecology, Surgery, Ethics & Biostatistics, Psychiatry, and Uncategorized.

Features include:
- Study mode with specialty selection, instant answer feedback, and clinical explanations.
- Exam mode with 10, 25, 50, or 100-question blocks.
- Timed (90 seconds per question) and untimed exams.
- Score summary and review of all, incorrect, or flagged questions.
- Bookmarks, keyword/recall-number search, question-grid navigation, text scaling, dark/light themes, and saved progress.

## Import the Android project

1. Download the supplied `SMLE_Recall_Pro_Android_GitHub(1).zip` archive and extract it.
2. Upload **all extracted files and folders to the repository root**, preserving their directory structure. Include hidden folders such as `.github/workflows`.
3. After `.github/workflows/build-apk.yml` is present, push/commit the import. The workflow builds the APK on GitHub Actions.

## Build and download the APK

1. Open the **Actions** tab and select **Build Android APK**.
2. Wait for the workflow to complete successfully.
3. Download the `SMLE-Recall-Pro-APK` artifact from the workflow run. The workflow also publishes a GitHub Release for pushes and manual runs.

The provided release configuration uses the Android debug signing key for convenience. This is suitable for personal testing/sideloading, not production distribution. Configure a private release keystore before publishing a production app.

## Project structure in the supplied archive

- `app/src/main/java/com/smle/recallpro/MainActivity.kt` — Android activity and JavaScript bridge.
- `app/src/main/assets/index.html` — local MCQ application interface.
- `app/src/main/assets/questions_data.js` and `questions.json` — bundled MCQ content.
- `app/src/main/res/` — Android resources and themes.
- `.github/workflows/build-apk.yml` — GitHub Actions build workflow.

## Content and clinical-use note

The count and categories describe the supplied data file. They do not establish independent verification of question accuracy, answer keys, explanations, or current clinical guidelines. Review clinical content before relying on it for study or patient care.

## Build requirements

- Android Gradle Plugin 8.3.2
- JDK 17
- Gradle 8.7
- Android SDK 34
- Minimum Android API 24
