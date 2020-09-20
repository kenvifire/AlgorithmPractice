import os
import sys
import json

def read_meta(file_path):
    current_file = open(file_path, 'r')
    lines = current_file.readlines()
    problem_url = None
    ## need better way to get the settings
    for line in lines:
        line = line.strip()
        url_index = line.find('https://leetcode.com/')
        if url_index != -1:
            problem_url = line[url_index:]

    return problem_url

def main():
    walk_dir = sys.argv[1]
    build_dir = os.path.join(os.getcwd(), 'build')
    print('walk_dir = ' + walk_dir)

    if not os.path.exists(build_dir):
        os.makedirs(build_dir)
    # If your current working directory may change during script execution, it's recommended to
    # immediately convert program arguments to an absolute path. Then the variable root below will
    # be an absolute path as well. Example:
    # walk_dir = os.path.abspath(walk_dir)

    print('walk_dir (absolute) = ' + os.path.abspath(walk_dir))
    meta_file_path = os.path.join(walk_dir, build_dir, 'code_index.json')
    print(meta_file_path)
    meta_file = open(meta_file_path, 'w')

    meta_content = "["
    for root, _, files in os.walk(walk_dir):

        for filename in files:
            if filename.endswith('.java'):
                file_path = os.path.join(root, filename)

                print('\t- file %s (full path: %s)' % (filename, file_path))
                problem_url = read_meta(file_path)

                if problem_url is not None:
                    meta_json = {
                        'problem_url': problem_url,
                        'path': file_path,
                        'name': filename
                    }
                    meta_content += json.dumps(meta_json) + ","
    if len(meta_content) > 1:
        meta_content = meta_content[:-1]
    meta_content += ']'
    parsed_meta_content = json.loads(meta_content)
    meta_file.write(json.dumps(parsed_meta_content, indent=4, sort_keys=True, ensure_ascii=False))
    meta_file.close()

if __name__ == "__main__":
    main()
