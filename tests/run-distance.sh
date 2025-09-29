#!/bin/bash
echo "📏 Running Distance Converter Tests..."
cd "$(dirname "$0")/.."
mvn -q test -Dtest=DistanceConverterTest
