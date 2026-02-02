
# ETLPipeline

## Overview
ETLPipeline.java implements an Extract, Transform, Load pipeline for data processing operations.

## How It Works
1. **Extract**: Reads data from source systems
2. **Transform**: Processes and converts data between formats (handles floats, strings, BigDecimal, etc.)
3. **Load**: Writes transformed data to destination systems

## Key Features
- Type conversion handling for numeric and string data
- Support for BigDecimal precision calculations
- Configurable pipeline stages

## Note
AI assistance was used during development for debugging type conversion issues between floats, strings, and BigDecimal values.
