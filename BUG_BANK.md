# 🐞 BlockDAG Explorer Regression Bank
**Target System**: [https://awakening.bdagscan.com/](https://awakening.bdagscan.com/)
**Status**: 🟢 Active / Live Regression Suite
**Total Tests**: 20

This repository contains a suite of **20 Live Regression Tests** designed to verify the stability of the BlockDAG Explorer.

## 🚀 Quick Start

### Run All Tests (Parallel)
```bash
mvn test
```

### Run Specific Test
```bash
mvn -Dtest=Bdag_Solved_01_ValidSearch test
```

---

## 🏗 Architecture
The suite uses a **Page Object / Base Test** pattern for maintainability:
*   **`BaseTest.java`**: Handles WebDriver initialization, browser configuration (e.g., resolution, sandbox), and cleanup.
*   **`Bdag_Solved_XX.java`**: Individual test classes extending `BaseTest`.

---

## 📋 Test Inventory
 
 ### Core Navigation & Data
 | ID | Test Class | Description |
 | :--- | :--- | :--- |
 | **01** | `Bdag_Solved_01_ValidSearch` | **Valid Search**: Verifies block/hash search redirects to details. |
 | **02** | `Bdag_Solved_02_InvalidSearchRedirect` | **Invalid Search**: Verifies 404 redirection for bad inputs. |
 | **03** | `Bdag_Solved_03_LatestBlocksLoad` | **Latest Blocks**: checks dashboard block table population. |
 | **04** | `Bdag_Solved_04_SocialLinks` | **Social Links**: Validates footer social icons (Twitter/X). |
 | **05** | `Bdag_Solved_05_AddressPageValues` | **Address Page**: Ensures address details load correctly. |
 | **06** | `Bdag_Solved_06_TxnTabsSwitch` | **Tab Switching**: Verifies logic between Blocks/Txns tabs. |
 | **07** | `Bdag_Solved_07_TxnDetails` | **Txn Details**: Validates transaction detail view. |
 | **08** | `Bdag_Solved_08_CopyButton` | **Copy Button**: Checks interaction of 'Copy' UI elements. |
 | **09** | `Bdag_Solved_09_GasTracking` | **Gas Tracker**: Verifies visibility of Network Gas Price. |
 | **10** | `Bdag_Solved_10_LogoNavigation` | **Logo Nav**: Tests Homepage return via Logo click. |
 
 ### Edge Cases & Metadata
 | ID | Test Class | Description |
 | :--- | :--- | :--- |
 | **11** | `Bdag_Solved_11_ViewAllBlocks` | **View All Links**: Findings footer navigation links. |
 | **12** | `Bdag_Solved_12_ErrorPageHomeButton` | **Error Recovery**: Tests 'Go Home' button on 404 page. |
 | **13** | `Bdag_Solved_13_MobileResponsiveness` | **Responsiveness**: Simulates Mobile Viewport stability. |
 | **14** | `Bdag_Solved_14_BlockZeroCheck` | **Input Validation**: Accepts numeric inputs (Block 0). |
 | **15** | `Bdag_Solved_15_NetworkMetrics` | **Network Metrics**: Verifies 'Total Transactions' label and value visibility. |
 | **16** | `Bdag_Solved_16_FooterDapps` | **dApps Link**: Checks ecosystem integration links. |
 | **17** | `Bdag_Solved_17_PageTitle` | **SEO Title**: Validates Page Title tags. |
 | **18** | `Bdag_Solved_18_HttpsSecurity` | **HTTPS Force**: Tests security redirection. |
 | **19** | `Bdag_Solved_19_SearchPlaceholder` | **UX Hints**: Checks search placeholder text. |
 | **20** | `Bdag_Solved_20_MinerAppLink` | **Product Links**: Verifies Miner App integration. |
 
 ### Extended Module Verification
 | ID | Test Class | Description |
 | :--- | :--- | :--- |
 | **21** | `Bdag_Solved_21_Token_ListLoad` | **Token List**: Verifies the Token list page loads correctly. |
 | **22** | `Bdag_Solved_22_Token_Invalid` | **Invalid Token**: Checks handling of invalid token IDs. |
 | **23** | `Bdag_Solved_23_NFT_MintList` | **NFT Mints**: Verifies NFT Minting list loads populated data. |
 | **24** | `Bdag_Solved_24_NFT_Invalid` | **Invalid NFT**: Checks graceful handling of non-existent NFTs. |
 | **25** | `Bdag_Solved_25_Node_MapLoad` | **Node Map**: Validates the Node Map visualization loads. |
 | **26** | `Bdag_Solved_26_Node_Toggle` | **Node Toggle**: Verifies interactive toggles on Node page. |
 | **27** | `Bdag_Solved_27_Contact_Link` | **Contact**: Tests internal Contact/Support navigation. |
 | **28** | `Bdag_Solved_28_Contact_External` | **External Support**: Validates external support portal links. |
