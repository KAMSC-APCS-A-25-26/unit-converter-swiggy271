#!/bin/bash
echo "🧪 Running All Unit Converter Tests..."
cd "$(dirname "$0")/.."
mvn -q test
