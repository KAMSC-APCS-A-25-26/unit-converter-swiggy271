#!/bin/bash
echo "🌡️  Running Temperature Converter Tests..."
cd "$(dirname "$0")/.."
mvn -q test -Dtest=TempConverterTest
