#!/bin/bash
echo "⏰ Running Time Converter Tests..."
cd "$(dirname "$0")/.."
mvn -q test -Dtest=TimeConverterTest
