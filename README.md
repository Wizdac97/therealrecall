# SMLE Recall Pro — Android Medical MCQ App

A native Android wrapper around an offline-first medical multiple-choice question bank. The application UI is rendered locally in an Android WebView using bundled HTML, CSS, JavaScript, and question data.

## Included features

- Study mode with specialty selection and immediate answer feedback and explanations.
- Exam mode with configurable 10, 25, 50, or 100-question blocks.
- Timed (90 seconds per question) and untimed exams.
- Post-exam score summary and review filters for all, incorrect, and flagged questions.
- Bookmarks, question search, question-grid navigation, text scaling, dark/light themes, and saved progress.
- Bundled question bank: 525 supplied MCQs across Pediatrics, Internal Medicine, Obstetrics & Gynecology, Surgery, Ethics & Biostatistics, Psychiatry, and Uncategorized.

## Build APK with GitHub Actions

1. Open the **Actions** tab and select **Build Android APK**.
2. Run the workflow manually with **Run workflow**, or push a commit to trigger it.
3. Download the `SMLE-Recall-Pro-APK` artifact from the completed workflow run. The workflow also publishes a GitHub Release on pushes and manual runs.

The APK is an unsigned-for-production/debug-key-signed release build intended for personal testing and sideloading. Do not distribute it as a production-signed app without configuring a private release keystore.

## Project structure

- `app/src/main/java/.../MainActivity.kt` — Android activity and JavaScript bridge.
- `app/src/main/assets/index.html` — local MCQ application interface.
- `app/src/main/assets/questions_data.js` and `questions.json` — bundled MCQ content.
- `app/src/main/res/` — Android resources and themes.
- `.github/workflows/build-apk.yml` — CI workflow to compile and upload APKs.

## Content note

Question count and categories describe the supplied data file. They do not constitute independent verification of question accuracy, answer keys, explanations, or current clinical guidelines. Review clinical content before relying on it for study or patient care.

## Requirements

- Android Studio / Android Gradle Plugin 8.3.2
- JDK 17
- Gradle 8.7
- Android SDK 34
- Minimum Android API 24
