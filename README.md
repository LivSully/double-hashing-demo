GitHub Collaboration Cheat Sheet (Alice & Bob)
1. Create & Clone the Repository
# Alice: on GitHub website
# → New Repository → Name: double-hashing-demo
# → Add README + Java .gitignore
# → Settings → Collaborators → Add Bob
# Both Alice & Bob: on their terminals
git clone https://github.com/<username>/double-hashing-demo.git cd double-hashing-demo
mkdir src
2. Alice’s Branch – Hash Table Code
git checkout -b alice-hash-table
# (Copy your DoubleHashingHashTable.java file into src/)
git add src/DoubleHashingHashTable.java
git commit -m "feat: add DoubleHashingHashTable implementation" git push -u origin alice-hash-table
3. Bob’s Branch – Main Demo Code
git checkout -b bob-main-demo
# (Copy your DoubleHashingDemo.java file into src/)
git add src/DoubleHashingDemo.java
git commit -m "feat: add DoubleHashingDemo main driver program" git push -u origin bob-main-demo
4. Create Pull Requests (on GitHub website)
Go to repo → “Compare & pull request” for your branch. Add title + description.
Assign your teammate as reviewer.
After review → Click “Merge Pull Request” into main.
5. Sync the Latest main
git checkout main git pull origin main
# (Optional: update your feature branch)
git checkout alice-hash-table # or bob-main-demo git merge main
6. Compile & Run Java Program
javac src/*.java
java -cp src DoubleHashingDemo
7. Best Practices
# Create a new branch for each new feature/fix
git checkout -b feature/<name>
# Pull latest main before starting work git checkout main
git pull origin main
# Add + commit changes often
git add .
git commit -m "feat: short description"
# Push to your branch and open PR git push -u origin feature/<name>
✅ Final Project Structure double-hashing-demo/ └── src/
├── DoubleHashingHashTable.java └── DoubleHashingDemo.java
← Alice’s file ← Bob’s file
